import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartcheckinComponent } from './components/startcheckin/startcheckin.component';
import { CheckinComponent } from './components/checkin/checkin.component';
import { ConfirmcheckinComponent } from './components/confirmcheckin/confirmcheckin.component';

const routes: Routes = [
  {path: 'startCheckIn', component: StartcheckinComponent},
  {path: 'checkin', component: CheckinComponent},
  {path: 'confirm', component: ConfirmcheckinComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
