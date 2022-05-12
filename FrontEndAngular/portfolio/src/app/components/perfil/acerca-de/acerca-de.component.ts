import { Component, OnInit, Input } from '@angular/core';
import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css'],
})
export class AcercaDeComponent implements OnInit {
  @Input()
  persona!: {
    id: number;
    sobreMi: String;
  };

  modalData = {
    message: '',
  };

  constructor(private portfolioService: PortfolioService) {}

  ngOnInit(): void {}

  saveEditAboutModal(id: number) {
    const body = this.modalData.message;
    this.portfolioService
      .modificarAcercaDePersona(id, body)
      .subscribe((data) => {
        console.log(JSON.stringify('data' + data));
        window.location.reload();
      });
  }
}
