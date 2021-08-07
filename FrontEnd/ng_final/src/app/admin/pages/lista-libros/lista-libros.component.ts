import { LibroPage } from './../../../interfaces/libro.interfaces';
import { Component, OnInit } from '@angular/core';
import { LibroService } from '../../services/libro.service';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-lista-libros',
  templateUrl: './lista-libros.component.html',
  styles: [
  ]
})
export class ListaLibrosComponent implements OnInit {

  columnas = ['portada', 'titulo', 'precio', 'fechaCreacion', 'acciones'];
  libroPage?:LibroPage;

  constructor(private libroservice : LibroService) { }

  ngOnInit(): void {
    this.listarLibros();
  }
  listarLibros(){
    this.libroservice.getLibros()
    .subscribe(data => this.libroPage= data);
  }

  onPaginateChange(event: PageEvent) {
    console.log(event);
    
    const pageIndex = event.pageIndex;
    const pageSize = event.pageSize;

    console.log('var', pageIndex, pageSize)

    this.libroservice.getLibros(pageIndex, pageSize)
      .subscribe(data => this.libroPage = data);
  }
}
