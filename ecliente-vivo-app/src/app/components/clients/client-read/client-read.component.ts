import { ClientService } from './../services/client.service';
import { Component, OnInit } from '@angular/core';
import { Client } from '../models/client.model';

@Component({
  selector: 'app-client-read',
  templateUrl: './client-read.component.html',
  styleUrls: ['./client-read.component.css']
})
export class ClientReadComponent implements OnInit {

  clients!: Client[];
  displayedColumns = ['id', 'nome', 'cpf', 'telefone1', 'telefone2', 'telefone3', 'actions'];

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    this.clientService.listAll().subscribe(clients => {
      this.clients = clients;
    });
  }

}
