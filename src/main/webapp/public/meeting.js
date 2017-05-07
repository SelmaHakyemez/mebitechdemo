var Meeting = React.createClass({

    getInitialState: function () {
        return {display: true};
    },
    handleDelete() {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/meeting",
            type: 'DELETE',
            success: function (result) {
                self.setState({display: false});
            },
            error: function (xhr, ajaxOptions, thrownError) {
                toastr.error(xhr.responseJSON.message);
            }
        });
    },
    handleUpdate:function(){
        return 'http://localhost:8080/meeting/createUpdate';
    },
    render: function () {
        if (this.state.display == false) return null;
        else return (
            <tr>
                <td>{this.props.meeting.name}</td>
                <td>{this.props.meeting.description}</td>
                <td>{this.props.meeting.department}</td>
                <td>
                    <button className="btn btn-info" onClick={this.handleDelete}>Sil</button>
                </td>
                <td>
                    <a className="btn btn-info" href={this.handleUpdate(this.props.meeting.meetingId)}>Düzenle</a>
                </td>
            </tr>
        );
    }
});

var MeetingTable = React.createClass({

    render: function () {

        var rows = [];
        this.props.meetings.forEach(function (meeting) {
            rows.push(
                <Meeting meeting={meeting} key={meeting.name}/>);
        });

        return (
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Adı</th>
                    <th>Soyadı</th>
                    <th>Maaşı</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>

        );
    }
});

var MeetingApp = React.createClass({

    loadMeetingsFromServer: function () {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/meeting",
        }).then(function (data) {
            self.setState({meetings: data});
        });

    },

    getInitialState: function () {
        return {meetings: []};
    },

    componentDidMount: function () {
        this.loadMeetingsFromServer();
    },

    render() {
        return ( <MeetingTable meetings={this.state.meetings}/> );
    }
});

ReactDOM.render(<MeetingApp />, document.getElementById('meetings'));