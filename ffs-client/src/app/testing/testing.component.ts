import { Component, OnInit } from '@angular/core';

import { ConnectionTestService } from '../connection-test.service';

@Component({
  selector: 'app-testing',
  templateUrl: './testing.component.html',
  styleUrls: ['./testing.component.css']
})
export class TestingComponent implements OnInit {

  constructor(private connectionService: ConnectionTestService) { }

  ngOnInit() {

  }

}
