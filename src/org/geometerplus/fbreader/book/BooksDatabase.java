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

package org.geometerplus.fbreader.book;

import java.util.*;

import org.geometerplus.zlibrary.core.filesystem.ZLFile;

import org.geometerplus.zlibrary.text.view.ZLTextPosition;

public abstract class BooksDatabase {
	private static BooksDatabase ourInstance;

	public static BooksDatabase Instance() {
		return ourInstance;
	}

	protected BooksDatabase() {
		ourInstance = this;
	}

	protected Book createBook(long id, long fileId, String title, String encoding, String language) {
		final FileInfoSet infos = new FileInfoSet(this, fileId);
		return createBook(id, infos.getFile(fileId), title, encoding, language);
	}
	protected Book createBook(long id, ZLFile file, String title, String encoding, String language) {
		return (file != null) ? new Book(id, file, title, encoding, language) : null;
	}
	protected void addAuthor(Book book, Author author) {
		book.addAuthorWithNoCheck(author);
	}
	protected void addTag(Book book, Tag tag) {
		book.addTagWithNoCheck(tag);
	}
	protected void setSeriesInfo(Book book, String series, String index) {
		book.setSeriesInfoWithNoCheck(series, index);
	}

	public /*protected*/ abstract void executeAsATransaction(Runnable actions);

	// returns map fileId -> book
	public /*protected*/ abstract Map<Long,Book> loadBooks(FileInfoSet infos, boolean existing);
	public /*protected*/ abstract void setExistingFlag(Collection<Book> books, boolean flag);
	public /*protected*/ abstract Book loadBook(long bookId);
	public /*protected*/ abstract void reloadBook(Book book);
	public /*protected*/ abstract Book loadBookByFile(long fileId, ZLFile file);

	protected abstract List<Author> listAuthors(long bookId);
	public /*protected*/ abstract List<Author> listAuthors();
	protected abstract List<Tag> listTags(long bookId);
	public /*protected*/ abstract List<Tag> listTags();
	protected abstract SeriesInfo getSeriesInfo(long bookId);
	public /*protected*/ abstract void updateBookInfo(long bookId, long fileId, String encoding, String language, String title);
	public /*protected*/ abstract long insertBookInfo(ZLFile file, String encoding, String language, String title);
	protected abstract void deleteAllBookAuthors(long bookId);
	protected abstract void saveBookAuthorInfo(long bookId, long index, Author author);
	protected abstract void deleteAllBookTags(long bookId);
	protected abstract void saveBookTagInfo(long bookId, Tag tag);
	protected abstract void saveBookSeriesInfo(long bookId, SeriesInfo seriesInfo);

	protected FileInfo createFileInfo(long id, String name, FileInfo parent) {
		return new FileInfo(name, parent, id);
	}

	public /*protected*/ abstract Collection<FileInfo> loadFileInfos();
	public /*protected*/ abstract Collection<FileInfo> loadFileInfos(ZLFile file);
	public /*protected*/ abstract Collection<FileInfo> loadFileInfos(long fileId);
	public /*protected*/ abstract void removeFileInfo(long fileId);
	public /*protected*/ abstract void saveFileInfo(FileInfo fileInfo);

	public /*protected*/ abstract List<Long> loadRecentBookIds();
	public /*protected*/ abstract void saveRecentBookIds(final List<Long> ids);

	protected abstract List<Long> loadFavoriteIds();
	protected abstract boolean hasFavorites();
	protected abstract boolean isFavorite(long bookId);
	protected abstract void addToFavorites(long bookId);
	protected abstract void removeFromFavorites(long bookId);

	protected Bookmark createBookmark(long id, long bookId, String bookTitle, String text, Date creationDate, Date modificationDate, Date accessDate, int accessCounter, String modelId, int paragraphIndex, int wordIndex, int charIndex, boolean isVisible) {
		return new Bookmark(id, bookId, bookTitle, text, creationDate, modificationDate, accessDate, accessCounter, modelId, paragraphIndex, wordIndex, charIndex, isVisible);
	}

	public /*protected*/ abstract List<Bookmark> loadBookmarks(long bookId, boolean isVisible);
	public /*protected*/ abstract List<Bookmark> loadAllVisibleBookmarks();
	public /*protected*/ abstract long saveBookmark(Bookmark bookmark);
	public /*protected*/ abstract void deleteBookmark(Bookmark bookmark);

	public /*protected*/ abstract ZLTextPosition getStoredPosition(long bookId);
	public /*protected*/ abstract void storePosition(long bookId, ZLTextPosition position);

	public /*protected*/ abstract Collection<String> loadVisitedHyperlinks(long bookId);
	public /*protected*/ abstract void addVisitedHyperlink(long bookId, String hyperlinkId);
}
