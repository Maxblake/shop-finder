import React, { Component } from 'react';
import { geolocated } from 'react-geolocated';
import HomePageHeading from "./components/HomePageHeading"
import HomePageMenu from "./components/HomePageMenu";
import {Dimmer, Loader, Segment} from "semantic-ui-react";
import GeolocationNotSupportedHeader from "./components/GeolocationNotSupportedHeader";
import GeolocationNotEnabledHeader from "./components/GeoLocationNotEnabledHeader";
import './App.css';
import {setLocation} from "./actions";
import {connect} from "react-redux";
import {precisionRound} from "./utils/validation";

const mapDispatchToProps = dispatch => ({ setLocation: location => dispatch(setLocation(location)) })

class ConnectedApp extends Component {

  constructor(props) {
    super(props)

    this.state = {
      dimmerActive: true
    }

    this.handleCloseDimmer = this.handleCloseDimmer.bind(this)
  }

  handleCloseDimmer = () => this.setState({ dimmerActive: false })

  // TODO Fix constructor side-effects anti-pattern warning
  render() {
    const { dimmerActive } = this.state
    const { isGeolocationAvailable, isGeolocationEnabled, coords, setLocation } = this.props;

    const locationInfo = !isGeolocationAvailable
      ? <GeolocationNotSupportedHeader />
      : !isGeolocationEnabled
        ? <GeolocationNotEnabledHeader />
        : coords
          ? dimmerActive &&
            setLocation({ latitude: precisionRound(coords.latitude, 7), longitude: precisionRound(coords.longitude, 7) }) &&
            this.handleCloseDimmer()
          : <Loader>Getting the location data</Loader>

    return (
      <div>
        <Segment basic>
          <Dimmer.Dimmable blurring dimmed={dimmerActive}>
            <Dimmer active={dimmerActive} page>
              {locationInfo}
            </Dimmer>

            <HomePageMenu />
            <HomePageHeading />
          </Dimmer.Dimmable>
        </Segment>
      </div>
    )
  }
}

const App = connect(null, mapDispatchToProps)(ConnectedApp)

export default geolocated({
  positionOptions: {
    enableHighAccuracy: true,
    maximumAge: 0
  },
  userDecisionTimeout: null,
  geolocationProvider: navigator.geolocation
})(App)