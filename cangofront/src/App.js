import './App.css';
import AppBar from './components/appbar';
import TextForm from './components/textForm';
import CompaniesList from './components/companies';
import CompaniesListDropDown from './components/dropdown';
import CompaniesListBar from './components/searchingbar';
import CompaniesSearch from './components/companiesearch';

function App() {
  return (
    <div className="App">
    {/* <AppBar/> */}
    {/* <TextForm/> */}
    {/* <CompaniesList/> */}
    {/* <CompaniesListDropDown/> */}
    {/* <CompaniesListBar/> */}
    
    {<CompaniesSearch/>}
    </div>
  );
}


export default App;
