import { LibroService } from './../../../services/libro.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Libro } from 'src/app/interfaces/libro';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styles: [
  ]
})
export class ReactiveFormComponent implements OnInit {

  form!:FormGroup;

  constructor(
              private fb: FormBuilder,
              private libroService:LibroService
  ) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      titulo:[,[Validators.required, Validators.minLength(3)]],
      precio:[,[Validators.required]],
      publicacion:[true]
    })
  }

  crear(){
    if(this.form.invalid){
      this.form.markAllAsTouched();
      return;
    }
    const valoresFormulario = this.form.value;
    const libro: Libro = {
      id: new Date().getTime(),
      fechaCreacion: new Date(),
      ...valoresFormulario
    }
    this.libroService.crearLibro(libro);
    this.form.reset({
      publicacion:[false]
    });
  }

}
