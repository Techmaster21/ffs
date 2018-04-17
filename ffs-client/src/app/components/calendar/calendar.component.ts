import { Component, OnInit } from '@angular/core';
import { CalendarEvent } from 'angular-calendar';

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  }
};
/**
 * View for Calendar
 */
@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {
  viewDate: Date = new Date();
  // events: Array<CalendarEvent> = [];

  events: Array<CalendarEvent> = [
    {
      start: new Date(),
      end: new Date(),
      title: 'A 3 day event',
      color: colors.red
    }
    ]
  ngOnInit(): void {
  }
}
