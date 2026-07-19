import React, { Component } from "react";

class CountPeople extends Component {

    constructor() {
        super();

        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }

    updateEntry = () => {
        this.setState((prevState) => ({
            entrycount: prevState.entrycount + 1
        }));
    }

    updateExit = () => {
        this.setState((prevState) => ({
            exitcount: prevState.exitcount + 1
        }));
    }

    render() {
        return (
            <div style={{ marginTop: "80px", textAlign: "center" }}>

                <button onClick={this.updateEntry}>
                    Login
                </button>

                <span style={{ marginLeft: "10px", marginRight: "80px" }}>
                    {this.state.entrycount} People Entered!!!
                </span>

                <button onClick={this.updateExit}>
                    Exit
                </button>

                <span style={{ marginLeft: "10px" }}>
                    {this.state.exitcount} People Left!!!
                </span>

            </div>
        );
    }
}

export default CountPeople;