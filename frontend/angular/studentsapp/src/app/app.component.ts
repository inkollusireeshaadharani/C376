import { Component } from '@angular/core';
import { StudentdataService } from './studentdata.service';
import { Student } from './student';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'studentsapp';
  studentForm = new FormGroup({
    // rollno: new FormControl(''),
    name: new FormControl(''),
    mobileno: new FormControl(''),
    age: new FormControl(''),
    address: new FormControl(''),
  });

  constructor(private studentservice: StudentdataService) {}
  studentList: any[] | undefined;

  loadstudents() {
    return this.studentservice.GetStudents().subscribe((data: any) => {
      this.studentList = data;
    });
  }

  ngOnInit() {
    this.loadstudents();
  }

  deleteStudent(id: any): any {
    return this.studentservice.DeleteStudent(id).subscribe((data: any) => {
      this.loadstudents();
    });
  }

  editStudent(student: any) {
    return this.studentservice.UpdateStudent(student).subscribe((data: any) => {
      this.loadstudents();
    });
  }

  addStudent(student: any) {
    return this.studentservice.AddStudent(student).subscribe((data: any) => {
      this.loadstudents();
    });
  }

  onSubmit() {
    let student: Student = {
      // rollno: this.student.get('rollno')?.value as string,
      rollno: '1',
      name: this.studentForm.get('name')?.value as string,
      age: this.studentForm.get('age')?.value as string,
      address: this.studentForm.get('address')?.value as string,
      mobileNo: this.studentForm.get('mobileno')?.value as string,
    };

    this.addStudent(student);
  }

  // Add these lines to your AppComponent class
  searchForm = new FormGroup({
    searchName: new FormControl(''),
  });

  searchStudents() {
    const searchName = this.searchForm.get('searchName')?.value as string;
    this.studentservice
      .SearchStudentsByName(searchName)
      .subscribe((data: any) => {
        this.studentList = data;
      });
  }

  getStudents() {
    this.studentservice.GetStudents().subscribe((data: any) => {
      this.studentList = data;
    });
  }
}
