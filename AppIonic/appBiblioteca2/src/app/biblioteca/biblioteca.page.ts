import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlertController, NavController } from '@ionic/angular';
import { Libro } from '../models/Libro';
import { BibliotecaService } from '../service/biblioteca.service';

@Component({
  selector: 'app-biblioteca',
  templateUrl: './biblioteca.page.html',
  styleUrls: ['./biblioteca.page.scss'],
})
export class BibliotecaPage implements OnInit {
  libros: any = []

  constructor(private libroService: BibliotecaService, private alerControler: AlertController, private route:Router, private navController:NavController) { }

  ngOnInit() {
  }
  ionViewWillEnter() {
    this.cargarLibros()
  }

  cargarLibros() {
    this.libroService.obtenerLibros().subscribe(
      (res) => {
        this.libros = res
      },
      (err) => console.log(err)
    )
  }

  async eliminarLibro(libro: Libro) {
    const alert = await this.alerControler.create(
      {
        header: 'Eliminar libro',
        message: `¿Está seguro de eliminar el libro ${libro.nombre}?`,
        buttons: [
          {
            text: 'OK',
            handler: () => {
              this.libroService.eliminarLibro(libro._id).subscribe(
                (res) => {
                  this.cargarLibros()
                },
                (err) => console.log(err)
              )
            }
          },
          'Cancelar'
        ]
      }
    )
    alert.present()
  }

  actualizarCurso(libro: Libro) {
    this.route.navigate(['/registro'] , {queryParams: libro})
  }

  abrirFormulario(libro: Libro){
    this.navController.navigateForward(['/registro', libro._id])
  }

  abrirFormularioRegistro(){
    this.navController.navigateForward(['/registro', 'nuevo'])
  }

}



