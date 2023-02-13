import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Curso } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  API = "http://localhost:4500/api/curso"
  constructor(private http: HttpClient) { }

  obtenerCursos() {
    return this.http.get(this.API)
  }

  obtenerCurso(id: string) {
    return this.http.get(`${this.API}/${id}`)
  }

  insertarCurso(curso: Curso) {
    return this.http.post(this.API, curso)
  }

  eliminarCurso(id: any) {
    return this.http.delete(`${this.API}/${id}`)
  }

  actualizarCurso(id:any, curso:Curso){
    return this.http.put(`${this.API}/${id}`, curso)
  }
}
