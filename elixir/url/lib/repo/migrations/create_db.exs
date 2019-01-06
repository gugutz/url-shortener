defmodule URL.Repo.Migrations.CreateDB do
  use Ecto.Migration

  def change do
    create table(:ecto_urls) do
      add(:id, :integer)
      add(:url, :string)
      add(:hash, :string)
    end
  end
end
