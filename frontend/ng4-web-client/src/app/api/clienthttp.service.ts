import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Courses } from '../domain/courses.model';
import { Faculty } from '../domain/faculty.model';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class ClienthttpService {

  constructor(private http: HttpClient) { }

  getAllCourses(urlresource: string): Observable<Courses[]>{

    return this.http.get<Courses[]>(urlresource);
  }

  getAllFaculty(urlresource: string): Observable<Faculty[]>{

    return this.http.get<Faculty[]>(urlresource);
  }  

}
