import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
import { Libro } from '../models/Libro';
import { BibliotecaService } from '../service/biblioteca.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.page.html',
  styleUrls: ['./registro.page.scss'],
})
export class RegistroPage implements OnInit {
  id: any = "";
  estado:boolean=false;

  libro: any = {
    nombre: '',
    autor: '',
    editorial: '',
    precio: '',
    anioPublicacion: '',
    portada: ''
  }

  constructor(private bibliotecaService: BibliotecaService, private alerControler: AlertController, private route: Router,private router: ActivatedRoute) { }

  ngOnInit() {
    let id = this.router.snapshot.paramMap.get('_id');
    this.id = id;
    console.log(id);
    this.cargarLibro();
  }

  registrarLibro(libro:Libro){
    if(this.estado){
      if (this.id) {
        this.bibliotecaService.actualizarLibro(this.id, libro).subscribe(
          res => {
            console.log(res);
            this.route.navigate(['/biblioteca']);
          },
          err => console.log(err)
        );
        // return;
      }
      this.bibliotecaService.insertarLibro(libro).subscribe(
        res => {
          console.log(res);
          this.route.navigate(['/biblioteca']);
        },
        err => console.log(err)
      );
    }
    else{
      alert("Debe aceptar los terminos y condiciones");
    }

  }


  cargarLibro(){

    this.bibliotecaService.obtenerLibro(this.id).subscribe(
      res => {
        this.libro = res;
      },
      err => console.log(err)
    );
  }

  updateEstado(){
    //this.estado = !this.estado;
    console.log(this.estado);
    var boton = document.getElementById("boton");
  }

}
