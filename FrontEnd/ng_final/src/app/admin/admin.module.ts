import { ListaLibrosComponent } from './pages/lista-libros/lista-libros.component';
import { AdminRoutingModule } from './admin-routing.module';
import { LayoutComponent } from './layout/layout.component';
import { MaterialModule } from './../material/material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NuevoLibroComponent } from './pages/nuevo-libro/nuevo-libro.component';



@NgModule({
  declarations: [LayoutComponent, ListaLibrosComponent, NuevoLibroComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MaterialModule,
    AdminRoutingModule,
  ]
})
export class AdminModule { }
