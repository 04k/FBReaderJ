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

package org.geometerplus.android.fbreader.preferences.activityprefs;

import java.util.*;

import android.app.Activity;
import android.content.*;
import android.preference.Preference;

import org.geometerplus.zlibrary.core.resources.ZLResource;
import org.geometerplus.zlibrary.core.util.MiscUtil;

import org.geometerplus.android.fbreader.preferences.ZLReloadable;

public class ZLActivityPreference extends Preference {
	private ZLReloadable myBoundPref = null;

	public static interface ListHolder {
		public List<String> getValue();
		public void setValue(List<String> l);
	}

	private final ListHolder myHolder;
	private final int myRequestCode;
	protected List<String> mySuggestions;

	public ZLActivityPreference(Context context, ListHolder holder, Map<Integer,ZLActivityPreference> map, List<String> suggestions, ZLResource rootResource, String resourceKey) {
		super(context);
		myHolder = holder;
		myRequestCode = map.size();
		map.put(myRequestCode, this);
		mySuggestions = suggestions != null ? suggestions : new ArrayList<String>();

		ZLResource resource = rootResource.getResource(resourceKey);
		setTitle(resource.getValue());
		updateSummary();
	}

	public void setBoundPref(ZLReloadable boundPref) {
		myBoundPref = boundPref;
	}

	protected Intent prepareIntent(Intent intent) {
		intent.setClass(getContext(), EditableStringListActivity.class);
		return intent;
	}

	@Override
	protected void onClick() {
		final Intent intent = new Intent();
		intent.putStringArrayListExtra(
			BaseStringListActivity.LIST,
			new ArrayList<String>(myHolder.getValue())
		);
		intent.putStringArrayListExtra(
			BaseStringListActivity.SUGGESTIONS,
			new ArrayList<String>(mySuggestions)
		);
		intent.putExtra(BaseStringListActivity.TITLE, getTitle());

		((Activity)getContext()).startActivityForResult(prepareIntent(intent), myRequestCode);
	}

	public void setValue(Intent data) {
		final List<String> value = data.getStringArrayListExtra(EditableStringListActivity.LIST);
		myHolder.setValue(value);
		updateSummary();
		if (myBoundPref != null) {
			myBoundPref.reload();
		}
	}

	private void updateSummary() {
		setSummary(MiscUtil.join(myHolder.getValue(), ":"));
	}
}
