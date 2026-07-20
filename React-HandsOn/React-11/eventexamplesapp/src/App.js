import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {

  constructor() {
    super();

    this.state = {
      counter: 0
    };
  }

  increment = () => {
    this.setState({
      counter: this.state.counter + 1
    });
  };

  decrement = () => {
    this.setState({
      counter: this.state.counter - 1
    });
  };

  sayHello = () => {
    alert("Hello! Have a nice day.");
  };

  increase = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (msg) => {
    alert(msg);
  };

  onPress = () => {
    alert("I was clicked");
  };

  render() {

    return (

      <div style={{ padding: "20px" }}>

        <h2>{this.state.counter}</h2>

        <button onClick={this.increase}>
          Increment
        </button>

        <br /><br />

        <button onClick={this.decrement}>
          Decrement
        </button>

        <br /><br />

        <button
          onClick={() => this.sayWelcome("Welcome")}
        >
          Say Welcome
        </button>

        <br /><br />

        <button onClick={this.onPress}>
          Click on me
        </button>

        <br /><br />

        <CurrencyConvertor />

      </div>

    );
  }
}

export default App;