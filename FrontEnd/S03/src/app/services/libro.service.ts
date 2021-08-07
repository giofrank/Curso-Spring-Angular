import { Libro } from './../interfaces/libro';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LibroService {
  private _libros: Libro[] = [];

  constructor() { 
    this._libros = JSON.parse(localStorage.getItem('MIS_LIBROS') || '[]');// localStorage.getItem('MIS_LIBROS'); A LA INVERSA
  }

  crearLibro(libro: Libro){
    this._libros.push(libro);
    localStorage.setItem('MIS_LIBROS',JSON.stringify(this._libros));
  }

  get libros(){
    return this._libros
  }
}
