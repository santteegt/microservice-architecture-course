import { Component, OnInit } from '@angular/core';
import { Faculty } from '../domain/faculty.model';
import { ClienthttpService } from '../api/clienthttp.service';

@Component({
  selector: 'app-faculty',
  templateUrl: './faculty.component.html',
  styleUrls: ['./faculty.component.css']
})
export class FacultyComponent implements OnInit {

  faculty: Faculty[];
  url = "http://localhost:8082/registry/faculty";

  constructor(private clienthttpService: ClienthttpService) { }

  ngOnInit() {
    this.clienthttpService.getAllFaculty(this.url)
    .subscribe(response => {
      this.faculty = response;
  });
  }

}
