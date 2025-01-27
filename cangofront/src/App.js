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
      {/* <TextForm/> */}

      {<SimpleCompanySearch />}
      {<SimpleServiceSearch />}
      {/* <div className='container>' */}
      <div className="container">
        <FetchDataButton endpoint="service" />
        <FetchDataButton endpoint="alias"/>
        <FetchDataButton />
      </div>
    </div>
  );
}

export default App;
