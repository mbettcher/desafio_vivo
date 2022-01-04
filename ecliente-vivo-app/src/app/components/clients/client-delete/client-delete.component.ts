import { Router, ActivatedRoute } from '@angular/router';
import { Client } from './../models/client.model';
import { Component, OnInit } from '@angular/core';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-client-delete',
  templateUrl: './client-delete.component.html',
  styleUrls: ['./client-delete.component.css'],
})
export class ClientDeleteComponent implements OnInit {
  client!: Client;

  constructor(
    private clientService: ClientService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.clientService.findById(id!).subscribe((client) => {
      this.client = client;
    });
  }

  deleteClient(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.clientService.deleteCliente(id!).subscribe(() => {
      this.clientService.showMessage('Produto excluído com sucesso!');
      this.router.navigate(['/clientes']);
    });
  }

  cancel(): void {
    this.router.navigate(['/clientes']);
  }
}
