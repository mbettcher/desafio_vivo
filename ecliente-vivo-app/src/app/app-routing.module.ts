import { ClientDeleteComponent } from './components/clients/client-delete/client-delete.component';
import { ClientUpdateComponent } from './components/clients/client-update/client-update.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { ClientCrudComponent } from './views/client-crud/client-crud.component';
import { ClientCreateComponent } from './components/clients/client-create/client-create.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },{
    path: "clientes",
    component: ClientCrudComponent
  },{
    path: "clientes/novo",
    component: ClientCreateComponent
  },{
    path: "clientes/atualizar/:id",
    component: ClientUpdateComponent
  },{
    path: "clientes/excluir/:id",
    component: ClientDeleteComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
