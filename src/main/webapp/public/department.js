/**
 * Created by Selma on 07.05.2017.
 */
var Department = React.createClass({

    getInitialState: function () {
        return {display: true};
    },
    handleDelete() {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/department",
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
        return 'http://localhost:8080/department/createUpdate';
    },
    render: function () {
        if (this.state.display == false) return null;
        else return (
            <tr>
                <td>{this.props.department.name}</td>
                <td>{this.props.department.description}</td>
                <td>
                    <button className="btn btn-info" onClick={this.handleDelete}>Sil</button>
                </td>
                <td>
                    <a className="btn btn-info" href={this.handleUpdate(this.props.department.departmentId)}>Düzenle</a>
                </td>
            </tr>
        );
    }
});

var DepartmentTable = React.createClass({

    render: function () {

        var rows = [];
        this.props.departments.forEach(function (department) {
            rows.push(
                <Department department={department} key={department.name}/>);
        });

        return (
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Adı</th>
                    <th>Açıklaması</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>

        );
    }
});

var DepartmentApp = React.createClass({

    loadDepartmentsFromServer: function () {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/department",
        }).then(function (data) {
            self.setState({departments: data});
        });

    },

    getInitialState: function () {
        return {departments: []};
    },

    componentDidMount: function () {
        this.loadDepartmentsFromServer();
    },

    render() {
        return ( <DepartmentTable departments={this.state.departments}/> );
    }
});

ReactDOM.render(<DepartmentApp />, document.getElementById('departments'));