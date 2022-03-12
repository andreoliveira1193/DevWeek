import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HttpClientModule} from '@angular/common/http'
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';

import { OcorrenciasRoutingModule } from './ocorrencias-routing.module';
import { OcorrenciasComponent } from './ocorrencias/ocorrencias.component';
import {MatSortModule} from '@angular/material/sort';
import {MatCardModule} from '@angular/material/card'; 
import { OcorrenciaService } from './service/ocorrencia.service';
import { RegiaoService } from './service/regiao.service';
import { FaixaetariaService } from './service/faixaetaria.service';

@NgModule({
  declarations: [
    OcorrenciasComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    OcorrenciasRoutingModule,
    MatSortModule,
    MatCardModule,
    MatTableModule,
    MatToolbarModule

  ],
  providers:[
    OcorrenciaService,
    RegiaoService,
    FaixaetariaService
  ]
})
export class OcorrenciasModule { }
