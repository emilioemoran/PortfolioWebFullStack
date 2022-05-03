import { Component, OnInit, Input } from '@angular/core';
import { observeOn } from 'rxjs/operators';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-encabezado',
  templateUrl: './encabezado.component.html',
  styleUrls: ['./encabezado.component.css'],
})
export class EncabezadoComponent implements OnInit {
  modalData = { nombre: '', compania: '', ubicacion: '', posicion: '' };
  encabezado = { nombre: '', compania: '', ubicacion: '', posicion: '' };

  constructor(private portfolioService: PortfolioService) {}

  @Input()
  persona!: {
    id: number;
    nombre: String;
    posicion: String;
    compania: String;
    ubicacion: String;
  };

  ngOnInit(): void {}

  saveEditProfileModal(id: number, body: any) {
    this.encabezado = this.modalData;
    this.portfolioService.modificarDatosPersona(id, this.encabezado);
  }

  /* showModalEditaPerfil() {
    const dialogRef = this.dialog.open(ModalEditaPerfilComponent);

    dialogRef.afterClosed().subscribe((result: String) => {
      console.log(`Dialog result: ${result}`);
    });
  } */

  /* showEditProfileModal() {
    const dialogConfig = new MatDialogConfig();
    // The user can't close the dialog by clicking outside its body
    dialogConfig.disableClose = true;
    dialogConfig.id = 'modal-component';
    dialogConfig.height = '350px';
    dialogConfig.width = '600px';
    // https://material.angular.io/components/dialog/overview
    const modalDialog = this.dialog.open(ModalEditaPerfilComponent);
    modalDialog.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  } */
}
