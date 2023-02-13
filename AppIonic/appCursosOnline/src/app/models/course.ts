export class Curso {
  _id?: string
  name: string
  subtitle: string
  duration: string
  description: string
  urlImage: string

  constructor(name: string, subtitle: string, duration: string, description: string, urlImage: string) {
    this.name = name
    this.subtitle = subtitle
    this.duration = duration
    this.description = description
    this.urlImage = urlImage
  }
}
