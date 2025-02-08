// src/App.js
import "./App.css";
import AppBar from "./components/appbar";
import TextForm from "./components/textForm";
import SimpleCompanySearch from "./components/simplecompanysearch";
import SimpleServiceSearch from "./components/simpleservicesearch";
import FetchDataButton from "./components/fetchbutton";
import DateFields from "./components/DateFields";
import React from 'react';

function App() {
  return (
    <div className="App">
      <AppBar />
      <div className="container">
        <div className="column">
          <SimpleServiceSearch />
        </div>
        <div className="column">
          <SimpleCompanySearch />
        </div>
        <div className="column">
          <DateFields />
        </div>
        <div className="buttons-container">
          <FetchDataButton className="fetch-data-button" endpoint="service" />
          <FetchDataButton className="fetch-data-button" endpoint="alias" />
          <button className="fetch-data-button">Sign Can</button>
        </div>
      </div>
    </div>
  );
}

export default App;
