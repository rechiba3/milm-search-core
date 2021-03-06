/*
 * MilmSearch is a mailing list searching system.
 *
 * Copyright (C) 2013 MilmSearch Project.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 *
 * You can contact MilmSearch Project at mailing list
 * milm-search-public@lists.sourceforge.jp.
 */
package org.milmsearch.core.domain

import java.net.URL
import org.joda.time.DateTime

/**
 * ML情報
 *
 * @param id ID
 * @param title MLのタイトル
 * @param archiveType MLのアーカイブのタイプ
 * @param archiveURL MLのアーカイブページのURL
 * @param lastMailedAt 最終投稿日時
 * @param approvedAt ML登録申請が承認された日時
 */
case class ML(
  id: Long,
  title: String,
  archiveType: MLArchiveType.Value,
  archiveURL: URL,
  lastMailedAt: Option[DateTime],
  approvedAt: DateTime)

/**
 * ML情報の作成要求
 */
case class CreateMLRequest(
  title: String,
  archiveType: MLArchiveType.Value,
  archiveURL: URL,
  approvedAt: DateTime)

/**
 * ML情報の絞り込みに使える項目
 */
object MLFilterBy extends FilterByEnum {
  val Title = Value("title")
}

/**
 * ML情報の並べ替えに使える項目
 */
object MLSortBy extends SortByEnum {
  val Title        = Value("title")
  val LastMailedAt = Value("lastMailedAt")
}

/**
 * ML情報の検索結果
 */
case class MLSearchResult(
  totalResults: Long,
  startIndex: Long,
  itemsPerPage: Long,
  items: List[ML]) extends SearchResult[ML]