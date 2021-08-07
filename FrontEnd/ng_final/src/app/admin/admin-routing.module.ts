import { NuevoLibroComponent } from './pages/nuevo-libro/nuevo-libro.component';
import { ListaLibrosComponent } from './pages/lista-libros/lista-libros.component';
import { LayoutComponent } from './layout/layout.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';


const router: Routes = [
    {

        path: 'admin',
        component:LayoutComponent,
        children:[
            {
            path:'libros',
            component: ListaLibrosComponent,
            },
            {
            path:'libros/nuevo',
            component: NuevoLibroComponent,
            }
        ]
    }


];



@NgModule({
    imports:[RouterModule.forChild(router)],
    exports: [RouterModule]
})
export class AdminRoutingModule{}