import { Component, OnInit } from '@angular/core';
import { subscribeOn, Subscription } from 'rxjs';
import { Faixaetaria } from '../model/faixaetaria';
import { Ocorrencia } from '../model/ocorrencia';
import { Regiao } from '../model/regiao';
import { FaixaetariaService } from '../service/faixaetaria.service';
import { OcorrenciaService } from '../service/ocorrencia.service';
import { RegiaoService } from '../service/regiao.service';


@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {
  
regioes: Regiao[] = [];
ocorrencia_exame: Ocorrencia[] = [];
faixaetarias: Faixaetaria[] = [];

 readonly subscriptions = new Subscription();

  constructor(private regiaoService:RegiaoService,
              private ocorrenciaService: OcorrenciaService,
              private faixaEtariaService: FaixaetariaService              
              ) { }

  ngOnInit(): void {
    this.listRegioes();
    this.listarOcorrencias();
    this.listFaixaEtaria();
  };

  ngOnDestroy():void{
    this.subscriptions.unsubscribe();
  }

  private listRegioes():void{
    const Subscription = this.regiaoService.listRegioes().subscribe((regioes => {
      this.regioes = regioes;}));
  
 this.subscriptions.add(Subscription);
}

private listarOcorrencias():void{
  const SubscriptionOcorrencias = this.ocorrenciaService.listOcorrencias().subscribe((
    ocorrencias => {this.ocorrencia_exame = ocorrencias}
  ));
  this.subscriptions.add(SubscriptionOcorrencias);
}

private listFaixaEtaria(): void{
  const SubscriptionFaixas = this.faixaEtariaService.listFaixaEtaria().subscribe((
    faixa => {this.faixaetarias = faixa}
  ));

   this.subscriptions.add(SubscriptionFaixas);
}

}
