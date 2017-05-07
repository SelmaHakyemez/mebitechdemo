var Employee = React.createClass({

    getInitialState: function () {
        return {display: true};
    },
    handleDelete() {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/employee",
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
        return 'http://localhost:8080/employee/createUpdate';
    },
    render: function () {
        if (this.state.display == false) return null;
        else return (
            <tr>
                <td>{this.props.employee.name}</td>
                <td>{this.props.employee.description}</td>
                <td>{this.props.employee.salary}</td>
                <td>
                    <button className="btn btn-info" onClick={this.handleDelete}>Sil</button>
                </td>
                <td>
                    <a className="btn btn-info" href={this.handleUpdate(this.props.employee.employeeId)}>Düzenle</a>
                </td>
            </tr>
        );
    }
});

var EmployeeTable = React.createClass({

    render: function () {

        var rows = [];
        this.props.employees.forEach(function (employee) {
            rows.push(
                <Employee employee={employee} key={employee.name}/>);
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

var EmployeeApp = React.createClass({

    loadEmployeesFromServer: function () {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/employee",
        }).then(function (data) {
            self.setState({employees: data});
        });

    },

    getInitialState: function () {
        return {employees: []};
    },

    componentDidMount: function () {
        this.loadEmployeesFromServer();
    },

    render() {
        return ( <EmployeeTable employees={this.state.employees}/> );
    }
});

ReactDOM.render(<EmployeeApp />, document.getElementById('employees'));