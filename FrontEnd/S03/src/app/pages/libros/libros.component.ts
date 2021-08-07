import { Component, OnInit } from '@angular/core';
import { Libro } from 'src/app/interfaces/libro';
import { LibroService } from 'src/app/services/libro.service';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styles: [
  ]
})
export class LibrosComponent implements OnInit {

 

  constructor(private librosservice: LibroService) { }

  ngOnInit(): void {
  }

  get libros(){
    return this.librosservice.libros;
  }
}
