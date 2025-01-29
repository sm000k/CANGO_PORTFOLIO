import "./App.css";
import AppBar from "./components/appbar";
import TextForm from "./components/textForm";
import SimpleCompanySearch from "./components/simplecompanysearch";
import SimpleServiceSearch from "./components/simpleservicesearch";
import FetchDataButton from "./components/fetchbutton";

function App() {
  return (
    <div className="App">
    <AppBar />
  
    <div className="container">
      {/* Lewa kolumna - SimpleServiceSearch */}
      <div className="column service-search-column">
        <SimpleServiceSearch />
      </div>
  
      {/* Środkowa kolumna - Pusta */}
      <div className="column empty-column"></div>
  
      {/* Każdy przycisk w oddzielnej kolumnie */}
      <div className="buttons-container">
        <div className="column button-column">
          <FetchDataButton endpoint="service" />
        </div>
        <div className="column button-column">
          <FetchDataButton endpoint="alias" />
        </div>
        <div className="column button-column">
          <FetchDataButton endpoint="" />
        </div>
      </div>
    </div>
  </div>
  );
}

export default App;
