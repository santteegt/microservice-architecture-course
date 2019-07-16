import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ClienthttpService } from './api/clienthttp.service';
import { HttpClientModule } from '@angular/common/http';
import { CoursesComponent } from './courses/courses.component';
import { FacultyComponent } from './faculty/faculty.component';

@NgModule({
  declarations: [
    AppComponent,
    CoursesComponent,
    FacultyComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ClienthttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
