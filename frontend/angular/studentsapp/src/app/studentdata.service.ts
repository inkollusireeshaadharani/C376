import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Student } from './student';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class StudentdataService {
  constructor(private httpservice: HttpClient) {}
  studenturl: string = 'http://localhost:8080/students/';
  // Get Students
  GetStudents(): Observable<Student> {
    return this.httpservice
      .get<Student>(this.studenturl)
      .pipe(retry(3), catchError(this.myerrorhandler));
  }

  // Get Students by ID
  GetStudentById(id: number): Observable<Student> {
    return this.httpservice
      .get<Student>(this.studenturl + id)
      .pipe(retry(3), catchError(this.myerrorhandler));
  }

  // Add Students
  AddStudent(student: Student): Observable<Student> {
    console.log(student);
    return this.httpservice
      .post<Student>(this.studenturl, student)
      .pipe(retry(3), catchError(this.myerrorhandler));
  }

  // Update Students
  UpdateStudent(student: Student): Observable<Student> {
    return this.httpservice
      .put<Student>(this.studenturl + student.rollno, student)
      .pipe(retry(3), catchError(this.myerrorhandler));
  }

  // Delete Students
  DeleteStudent(id: number): Observable<any> {
    return this.httpservice
      .delete<Student>(this.studenturl + id)
      .pipe(retry(0), catchError(this.myerrorhandler));
  }
  // By name
  SearchStudentsByName(name: string): Observable<Student> {
    if (name === '') return this.GetStudents();
    return this.httpservice
      .get<Student>(this.studenturl + 'name/' + name)
      .pipe(retry(0));
  }

  // Error handling
  private myerrorhandler(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error(
        'An error occurred.. either client side or network:',
        error.error
      );
    } else {
      console.error(
        `Backend returned code ${error.status}, body was: `,
        error.error
      );
    }
    return throwError(
      () => new Error('Something bad happened; please try again later.')
    );
  }
}
