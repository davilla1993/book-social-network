/* tslint:disable */
/* eslint-disable */
import { HistoryBookResponse } from '../models/history-book-response';
export interface PageResponseHistoryBookResponse {
  content?: Array<HistoryBookResponse>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}
