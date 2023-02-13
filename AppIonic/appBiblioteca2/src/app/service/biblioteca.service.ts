import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Libro } from '../models/Libro';

@Injectable({
  providedIn: 'root'
})
export class BibliotecaService {

  API = "http://localhost:4500/api/libro"

  constructor(private http: HttpClient) { }

  obtenerLibros() {
    return this.http.get(this.API)
  }

  obtenerLibro(id: string) {
    return this.http.get(`${this.API}/${id}`)
  }

  insertarLibro(libro: Libro) {
    return this.http.post(this.API, libro)
  }

  eliminarLibro(id: any) {
    return this.http.delete(`${this.API}/${id}`)
  }

  actualizarLibro(id: any, libro: Libro) {
    return this.http.put(`${this.API}/${id}`, libro)
  }
}
