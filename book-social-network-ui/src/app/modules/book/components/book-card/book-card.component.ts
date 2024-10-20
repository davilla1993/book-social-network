import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BookResponse } from 'src/app/services/models';

@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.scss']
})
export class BookCardComponent {

  private _book: BookResponse = {};
  private _manage: boolean = false;
  private _bookCover: string | undefined;

  get book(): BookResponse {
    return this._book;
  }

  @Input()
  set book(value: BookResponse) {
    this._book = value;
  }

  get bookCover(): string | undefined {
    if(this._book.cover) {
      return 'data:image/jpg;base64, ' + this._book.cover;
    }
    return 'https://img.freepik.com/vecteurs-libre/illustration-api-degrade_23-2149385318.jpg?t=st=1729161858~exp=1729165458~hmac=d39181261a9af467358a409a443dee5550352863f9615e50370d32407b516223&w=1480';

  }

  get manage(): boolean {
    return this._manage;
  }

  @Input()
  set manage(value: boolean) {
    this._manage = value;
  }

  @Output()
  private share: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();

  @Output()
  private archive: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();

  @Output()
  private addToWaitingList: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();

  @Output()
  private borrow: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();

  @Output()
  private edit: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();

  @Output()
  private details: EventEmitter<BookResponse> = new EventEmitter<BookResponse>();


  onArchive() {
    this.archive.emit(this._book);
  }

  onShare() {
    this.share.emit(this._book);
  }

  onEdit() {
    this.edit.emit(this._book);
  }

  onAddWaitingList() {
    this.addToWaitingList.emit(this._book);
  }
    
  onBorrow() {
    console.log("BORROW OPERATION PROCESS : " + this._book);
    this.borrow.emit(this._book);
  }

  onShowDetails() {
    this.details.emit(this._book);
  }
}
