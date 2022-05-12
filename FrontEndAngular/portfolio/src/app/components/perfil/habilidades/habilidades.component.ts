import { Component, OnInit, Input } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css'],
})
export class HabilidadesComponent implements OnInit {
  @Input()
  persona!: {
    id: number;
    habilidades: any;
  };
  porcent: String = 'width: 0%';
  modalData: any = {};
  myItemModal: any;

  constructor(private portfolioService: PortfolioService) {}

  saveNewHabModal(id: number) {
    this.modalData.valor = 'width:' + this.modalData.valor.toString() + '%';
    const body = this.modalData;
    this.portfolioService.agregarHabilidad(id, body).subscribe(() => {
      window.location.reload();
    });
  }

  deleteHabModal(id: number, habilidad: any) {
    this.portfolioService.borrarHabilidad(id, habilidad).subscribe(() => {
      window.location.reload();
    });
  }

  selectItem(item: any) {
    this.myItemModal = item;
  }

  ngOnInit(): void {}
}
