import { Component } from '@angular/core';
import { IonContent, IonHeader, IonTitle, IonToolbar, IonButtons, IonMenuButton , IonMenu, IonItem, IonItemDivider, IonItemGroup, IonLabel, IonButton} from '@ionic/angular/standalone';
import { ExploreContainerComponent } from '../explore-container/explore-container.component';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss'],
  imports: [RouterLink,IonHeader, IonToolbar, IonTitle, IonContent,ExploreContainerComponent, IonButtons, IonMenuButton, IonMenu, IonItem, IonItemDivider, IonItemGroup, IonLabel],
})
export class Tab3Page {
  constructor() {}
}
