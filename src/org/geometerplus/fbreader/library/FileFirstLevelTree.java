/*
 * Copyright (C) 2009-2013 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.fbreader.library;

import org.geometerplus.zlibrary.core.resources.ZLResource;
import org.geometerplus.zlibrary.core.filesystem.ZLFile;

import org.geometerplus.fbreader.Paths;
import org.geometerplus.fbreader.book.IBookCollection;

public class FileFirstLevelTree extends FirstLevelTree {
	private final IBookCollection myCollection;

	FileFirstLevelTree(IBookCollection collection, RootTree root, String id) {
		super(root, id);
		myCollection = collection;
		boolean first = true;
		for (String s : Paths.BookPathOption().getValue()) {
			String resourceKey = first ? "fileTreeLibrary" : "fileTreeAddLibrary";
			addChild(s, s, Library.resource().getResource(resourceKey).getValue());
			first = false;
		}
		addChild("/", "fileTreeRoot");
		addChild(Paths.cardDirectory(), "fileTreeCard");
	}

	private void addChild(String path, String title, String summary) {
		final ZLFile file = ZLFile.createFileByPath(path);
		if (file != null) {
			new FileTree(
				this,
				myCollection,
				file,
				title,
				summary
			);
		}
	}

	private void addChild(String path, String resourceKey) {
		final ZLResource resource = Library.resource().getResource(resourceKey);
		addChild(path, resource.getValue(), resource.getResource("summary").getValue());
	}

	@Override
	public String getTreeTitle() {
		return getName();
	}

	@Override
	public Status getOpeningStatus() {
		return Status.READY_TO_OPEN;
	}
}
