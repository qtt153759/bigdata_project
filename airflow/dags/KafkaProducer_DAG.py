from datetime import timedelta
import airflow
from airflow import DAG
from airflow.operators.bash import BashOperator

default_args = {
    'owner': 'qtt',    
    'start_date': airflow.utils.dates.days_ago(2),
    # 'end_date': datetime(),
    # 'depends_on_past': False,
    # 'email': ['test@example.com'],
    #'email_on_failure': False,
    #'email_on_retry': False,
    # If a task fails, retry it once after waiting
    # at least 5 minutes
    #'retries': 1,
    'retry_delay': timedelta(minutes=5),
    }

dag = DAG(
    dag_id="example_dag_name",
    description="hello   airflow",
    schedule_interval='30 20 * * *',
    start_date=airflow.utils.dates.days_ago(5),
    default_args=default_args,
    max_active_runs=1
)


batchProducer = BashOperator(
    task_id="batchProducer",
    bash_command='java -jar /opt/airflow/dags/demo-1.0-SNAPSHOT.jar ',
    dag=dag)
batchProducer