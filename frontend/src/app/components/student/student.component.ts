import {Component, OnInit} from '@angular/core';
import {Student} from "../../models/student.madel";
import {StudentService} from "../../services/student.service";


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent implements OnInit  {

  displayedColumns: string[] = ['id', 'code', 'firstName', 'lastName','programId','actions'];
  dataSource:Student[] = [];

  searchQuery: string = '';
  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getStudents();
  }

  getStudents(): void {
    this.studentService.getAllStudents()
      .subscribe(students => {
      this.dataSource = students;
    });
  }
  searchStudents(): void {
    if (this.searchQuery.trim() === '') {
      this.getStudents();
      return;
    }
    this.studentService.findStudentsByFullName(this.searchQuery, this.searchQuery).subscribe(students => {
      this.dataSource = students;

    });
    this.getStudents();
  }
  deleteStudent(id: string): void {
    this.studentService.deleteStudent(id).subscribe(() => {
      this.dataSource = this.dataSource.filter(student => student.id !== id);
    });
  }

  editeStudent(student:Student) {


  }
}
