import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Libro } from 'src/app/interfaces/libro';
import { LibroService } from 'src/app/services/libro.service';

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
  styles: [
  ]
})
export class TemplateFormComponent implements OnInit {

  libro: Libro = {
    publicacion:true
  }

  constructor(

               private libroService:LibroService
  ) { }

  ngOnInit(): void {

  }

  crear(form: NgForm){
    if(form.invalid){
      form.form.markAllAsTouched;
      return;
    }

    const _libro: Libro = {
      id: new Date().getTime(),
      fechaCreacion: new Date(),
      ...this.libro
    }
    this.libroService.crearLibro(_libro);
    form.resetForm({
      publicacion:false
    });
  }


}
