defmodule URLTest do
  use ExUnit.Case
  doctest URL

  test "greets the world" do
    assert URL.hello() == :world
  end
end
