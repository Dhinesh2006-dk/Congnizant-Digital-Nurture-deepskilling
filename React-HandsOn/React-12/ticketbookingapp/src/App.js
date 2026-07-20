import React, { Component } from "react";

import Greeting from "./Greeting";
import LoginButton from "./LoginButton";
import LogoutButton from "./LogoutButton";

class App extends Component {

    constructor() {
        super();

        this.state = {
            isLoggedIn: false
        };
    }

    handleLogin = () => {
        this.setState({
            isLoggedIn: true
        });
    };

    handleLogout = () => {
        this.setState({
            isLoggedIn: false
        });
    };

    render() {

        const isLoggedIn = this.state.isLoggedIn;

        let button;

        if (isLoggedIn) {
            button = <LogoutButton onClick={this.handleLogout} />;
        } else {
            button = <LoginButton onClick={this.handleLogin} />;
        }

        return (

            <div style={{ padding: "30px" }}>

                <Greeting isLoggedIn={isLoggedIn} />

                <br />

                {button}

            </div>

        );

    }

}

export default App;