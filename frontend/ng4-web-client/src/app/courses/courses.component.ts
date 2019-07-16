import { Component, OnInit } from '@angular/core';
import { Courses } from '../domain/courses.model';
import { ClienthttpService } from '../api/clienthttp.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  subjects: Courses[];
  url = "http://localhost:8082/registry/courses";

  constructor(private clienthttpService: ClienthttpService) { }

  ngOnInit() {
      this.clienthttpService.getAllCourses(this.url)
      .subscribe(response => {
        this.subjects = response;
    });

  }
}