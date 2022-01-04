import { Client } from './../models/client.model';
import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-create',
  templateUrl: './client-create.component.html',
  styleUrls: ['./client-create.component.css']
})
export class ClientCreateComponent implements OnInit {

  client: Client = {
    nome: '',
    cpf: '',
    telefone1: '',
    telefone2: '',
    telefone3: ''
  }

  constructor(private clientService: ClientService,
    private router: Router ) { }

  ngOnInit(): void {
  }

  saveClient(): void {
    this.clientService.saveClient(this.client).subscribe(() => {
      this.clientService.showMessage('Cliente gravado com sucesso!');
      this.router.navigate(['clientes']);
    });
  }

  cancel(): void {
    this.router.navigate(['clientes']);
  }

}
