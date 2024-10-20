import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookResponse, PageResponseBookResponse } from 'src/app/services/models';
import { BookService } from 'src/app/services/services';

@Component({
  selector: 'app-my-books',
  templateUrl: './my-books.component.html',
  styleUrls: ['./my-books.component.scss']
})
export class MyBooksComponent implements OnInit {

  bookResponse: PageResponseBookResponse = {};
  page = 0;
  size = 5;

  constructor(private bookService: BookService, 
                private router: Router){ }


  ngOnInit(): void {
    this.findAllBooks();
  }
  findAllBooks() {
    this.bookService.findAllBooksByOwner({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (books: PageResponseBookResponse) => {
          this.bookResponse = books;
      }
    })   
  }

  goToFirstPage() {
    this.page = 0;
    this.findAllBooks();
  }

  goToPreviousPage() {
    this.page--;
    this.findAllBooks();
  }
  
  goToPage(index: number) {
    this.page = index;
    this.findAllBooks();
  }
  
  goToNextPage() {
    this.page++;
    this.findAllBooks();
  }

  goToLastPage(){
    this.page = this.bookResponse.totalPages as number - 1;
    this.findAllBooks();
  }

  get isLastPage(): boolean {
    return this.page == this.bookResponse.totalPages as number - 1;
  }

  editBook(book: BookResponse) {
    throw new Error('Method not implemented.');
    }
    shareBook(book: BookResponse) {
    throw new Error('Method not implemented.');
    }
    arhiveBook(book: BookResponse) {
    throw new Error('Method not implemented.');
    }

}
