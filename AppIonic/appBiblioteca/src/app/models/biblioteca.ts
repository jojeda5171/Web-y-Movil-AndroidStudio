export class Libro {
  _id?: string
  nombre: string
  autor: string
  editorial: string
  precio: string
  anioPublicacion: string
  portada: string

  constructor(nombre: string, autor: string, editorial: string, precio: string, anioPublicacion: string, portada: string) {
    this.nombre = nombre
    this.autor = autor
    this.editorial = editorial
    this.precio = precio
    this.anioPublicacion = anioPublicacion
    this.portada = portada
  }
}
