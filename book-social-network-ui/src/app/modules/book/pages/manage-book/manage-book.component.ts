import { Component } from '@angular/core';
import { BookRequest } from 'src/app/services/models/book-request';

@Component({
  selector: 'app-manage-book',
  templateUrl: './manage-book.component.html',
  styleUrls: ['./manage-book.component.scss']
})
export class ManageBookComponent {

  bookRequest: BookRequest = {
    authorName: '',
    isbn: '',
    synopsis: '',
    title: ''
  };
  errorMsg: Array<string> = [];
  selectedBookCover: any;
  selectedPicture: string | undefined;

  onFileSelected(event:any) {
   this.selectedBookCover = event.target.file[0];
   console.log(this.selectedBookCover);
   if(this.selectedBookCover) {
    const reader:FileReader = new FileReader();
    reader.onload = () => {
      this.selectedPicture = reader.result as string;
    }
    reader.readAsDataURL(this.selectedBookCover);
   }
  }

  saveBook() {
    
    }
}
